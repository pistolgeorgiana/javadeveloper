package ro.devmind.eventcorrelation.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
	private static String readFromJsonFile(String fileName) throws IOException {
		StringBuilder result = new StringBuilder();
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (sc.hasNextLine()) {
                result.append(sc.nextLine() + "\n");
            }
		}
		
		return result.toString();
	}
	
	public static JSONObject findObject(String json, List<String> positions) throws IOException, JSONException {
		JSONArray array = new JSONArray(json);
        if (array != null) {
			if (positions.size() > 2) {
				String comm = positions.get(0);
				int length = comm.equals("PUT") ? positions.size() - 2 : positions.size() - 1;
				JSONObject object = array.getJSONObject(Integer.valueOf(positions.get(1)));
				for (int i = 2; i < length; i++) {
					String keyObj = positions.get(i);
					if(keyObj.matches("-?(0|[1-9]\\d*)")) {
						if (array != null) {
							int index = Integer.valueOf(keyObj);
							if (index >= array.length()) {
								System.out.println(comm + "_ERROR_INDEX_OUT_OF_RANGE \"" + positions.get(i - 1) + "\"");
								return null;
							}
							object = array.getJSONObject(index);
							array = null;
						} else {
							System.out.println(comm + "_ERROR_NOT_ARRAY \"" + positions.get(i - 1) + "\"");
							return null;
						}
					} else {
						if(object != null) {
							List<String> keys = Arrays.asList(JSONObject.getNames(object));
							if (!keys.contains(keyObj)) {
								System.out.println(comm + "_KEY_NOT_FOUND \"" + keyObj + "\"");
								return null;
							}
							try {
								array = object.getJSONArray(keyObj);
								object = null;
							} catch (JSONException e) {
								object = object.getJSONObject(keyObj);
								array = null;
							}
						} else {
							System.out.println(comm + "_ERROR_NOT_OBJECT \"" + positions.get(i - 1) + "\"");
							return null;
						}
					}
				}
				return object;
			}
        }
        
        return null;
	}
	
	private static void displayGet(String json, List<String> positions) throws IOException, JSONException {
		JSONObject object = findObject(json, positions);
		if (object != null) {
			String keyObj = positions.get(positions.size() - 1);
			List<String> keys = Arrays.asList(JSONObject.getNames(object));
			if (!keys.contains(keyObj)) {
				System.out.println("GET_KEY_NOT_FOUND \"" + keyObj + "\"");
			} else {
				String res = object.get(keyObj).toString();
				if (res.matches("-?(0|[1-9]\\d*)") || res.equals("true") || res.equals("false")) {
					System.out.println(res);
				} else {
					System.out.println("\"" + res + "\"");
				}
			}
		}
	}
	
	private static void updateObject(String json, List<String> positions) throws IOException, JSONException {
		JSONObject object = findObject(json, positions);
		if (object != null) {
			String keyObj = positions.get(positions.size() - 2);
			List<String> keys = Arrays.asList(JSONObject.getNames(object));
			if (!keys.contains(keyObj)) {
				System.out.println("PUT_KEY_NOT_FOUND \"" + keyObj + "\"");
			} else {
				object.put(keyObj, positions.get(positions.size() - 1));
			}
		}
	}
	
	private static void deleteObject(String json, List<String> positions) throws IOException, JSONException {
		JSONObject object = findObject(json, positions);
		if (object != null) {
			String keyObj = positions.get(positions.size() - 2);
			List<String> keys = Arrays.asList(JSONObject.getNames(object));
			if (!keys.contains(keyObj)) {
				System.out.println("PUT_KEY_NOT_FOUND \"" + keyObj + "\"");
			} else {
				object.remove(keyObj);
			}
		}
	}
	
	private static void run(String...strings) throws IOException, JSONException {
		String json = readFromJsonFile(strings[0]);
		
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(strings[1])))) {
			while (sc.hasNextLine()) {
				String[] command = sc.nextLine().split("\"");
				List<String> positions = new ArrayList<String>();
				positions.addAll(Arrays.asList(command[0].split(" ")));
				for (int i = 1; i < command.length; i++) {
					if (command[i].trim().length() != 0) {
						positions.add(command[i].trim());
					}
				}
				
				String c = positions.get(0);
				if (!positions.get(1).matches("-?(0|[1-9]\\d*)")) {
					System.out.println(c + "_ERROR_NOT_OBJECT root");
				} else {
					if (c.equals("GET")) {
						displayGet(json, positions);
					} else if (c.equals("PUT")) {
						updateObject(json, positions);
					} else if (c.equals("DELETE")) {
						deleteObject(json, positions);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, JSONException {
		Scanner sc = new Scanner(System.in);
		String jsonFileName = sc.nextLine();
		String inputFileName = sc.nextLine();
		String outputFileName = sc.nextLine();
		sc.close();
		
		run(jsonFileName, inputFileName, outputFileName);
	}
}
