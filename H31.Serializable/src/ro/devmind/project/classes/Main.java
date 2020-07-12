package ro.devmind.project.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
 
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
 
        return sb.toString();
    }
	
	public static void displayList(List<Guest> list) {
		if(list != null && list.size() > 0) {
			for(Guest g : list) {
				System.out.println(g);
			}
		} else {
			System.out.println("Lista este goala!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Salutari! Te rugam sa introduci numarul locurilor disponibile...");
		File file = new File("commands.txt");
		VerifyMode mode;
		String key;
		try {
			String fileContent = readFile(file);
			List<String> commands = Arrays.asList(fileContent.split("\n"));
			System.out.println(commands.get(0));
			GuestsList list = new GuestsList(Integer.parseInt(commands.get(0)));
			int i = 1;
			while(!commands.get(i).equals("quit")) {
				System.out.println("Waiting for a command...(help - Show a list of commads)");
				String command = commands.get(i);
				System.out.println(command);
				switch(command) {
					case "help":
						System.out.println("help         - Afiseaza aceasta lista de comenzi\r\n" + 
								"add          - Adauga o noua persoana (inscriere)\r\n" + 
								"check        - Verifica daca o persoana este inscrisa la eveniment\r\n" + 
								"remove       - Sterge o persoana existenta din lista\r\n" + 
								"update       - Actualizeaza detaliile unei persoane\r\n" + 
								"guests       - Lista de persoane care participa la eveniment\r\n" + 
								"waitlist     - Persoanele din lista de asteptare\r\n" + 
								"available    - Numarul de locuri libere\r\n" + 
								"guests_no    - Numarul de persoane care participa la eveniment\r\n" + 
								"waitlist_no  - Numarul de persoane din lista de asteptare\r\n" + 
								"subscribe_no - Numarul total de persoane inscrise\r\n" + 
								"search       - Cauta toti invitatii conform sirului de caractere introdus\r\n" + 
								"quit         - Inchide aplicatia");
						break;
					case "add":
						mode = VerifyMode.valueOf(commands.get(++i).toUpperCase());
						String firstName = commands.get(++i);
						String lastName = commands.get(++i);
						String phone = commands.get(++i);
						String email = commands.get(++i);
						list.addPerson(mode, lastName, firstName, email, phone);
						break;
					case "check":
						mode = VerifyMode.valueOf(commands.get(++i).toUpperCase());
						key = (mode == VerifyMode.NAME) ? commands.get(++i) + " " + commands.get(++i) : commands.get(++i);
						System.out.println(key + (list.isEnrolled(mode, key) ? " Esti inscris!" : " Nu esti inscris!"));
						break;
					case "remove":
						System.out.println("Se sterge o persoana din lista...");
						mode = VerifyMode.valueOf(commands.get(++i).toUpperCase());
						key = (mode == VerifyMode.NAME) ? commands.get(++i) + " " + commands.get(++i) : commands.get(++i);
						System.out.println(list.removeGuest(mode, key) ? "Participantul a fost sters!" : "Participantul nu a fost inscris!");
						break;
					case "update":
						System.out.println("Se actualizeaza o persoana din lista...");
						mode = VerifyMode.valueOf(commands.get(++i).toUpperCase());
						key = (mode == VerifyMode.NAME) ? commands.get(++i) + " " + commands.get(++i) : commands.get(++i);
						VerifyMode change = VerifyMode.valueOf(commands.get(++i).toUpperCase());
						String value = (change == VerifyMode.NAME) ? commands.get(++i) + " " + commands.get(++i) : commands.get(++i);
						list.updateGuest(mode, key, change, value);
						break;
					case "guests":
						List<Guest> participants = list.getListParticipants();
						displayList(participants);
						break;
					case "waitlist":
						List<Guest> waiting = list.getWaitingList();
						displayList(waiting);
						break;
					case "available":
						System.out.println("Locuri disponibile: " + list.getAvailableSeats());
						break;
					case "guests_no":
						System.out.println("Numarul de participanti: " + list.getParticipantsNo());
						break;
					case "waitlist_no":
						System.out.println("Dimensiunea listei de asteptare: " + list.getWaitingNo());
						break;
					case "subscribe_no":
						System.out.println("Total inscrisi: " + list.getTotalNo());
						break;
					case "search":	
						String param = commands.get(++i);
						List<Guest> filtered = list.searchGuest(param);
						displayList(filtered);
						break;
					default:
						System.out.println("Te rugam sa incerci alta comanda");
						break;
				}
				i++;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
