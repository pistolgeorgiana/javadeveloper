package ro.devmind.surprise.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FortuneCookie implements ISurprise {
	private String message;
	private static List<String> fortunes;
	private static Random random = new Random();
	
	static {
		fortunes = Arrays.asList("Always tell the truth - it's the easiest thing to remember. - David Mamet",
				"It's better to have a bad plan then no plan at all. - Charles de Gaulle",
				"If we followed our own advice, we'd be successful. - Fred Astaire",
				"Forget goals. Value the process. - Jim Bouton",
				"What you earn depends on what you learn. - William J. Clinton",
				"The best way to make children good is to make them happy. - Oscar Wilde",
				"Wealth can't buy health, but health can buy wealth. - Henry D. Thoreau",
				"Somewhere, something incredible is waiting to be knwon. - Carl Sagan",
				"A day without laughter is a day wasted. - Charlie Chaplin",
				"The way to get thhings done is not to mind who gets the credit for doing them. - Benjamin Jowett",
				"Success is a lousy teacher. It seduces smart people into thinking they can't lose. - Bill Gates",
				"I have found that if you love life, life will love you back. - Arthur Rubinstein",
				"Our work is the presentation of our capabilities. - Edward Gibbon",
				"The good life is one inspired by love and guided by knowledge. - Bertrand Russell",
				"Step by step and the thing is done. - Charles Atlas",
				"Don't take life too seriously. You will never get out of it alive. - Elbert Hubbard",
				"A man who dares to waste one hour of time has not discovered the value of life. - Charles Darwin",
				"Nothing is a waste of time if you use the experience wisely. - Auguste Rodin",
				"There are no original ideas. There are only original people. - Barbara G. Harrison",
				"We know what we are, but know not what we may be. - William Shakespeare");
	}

	public FortuneCookie(String message)  {
		super();
		this.message = message;
	}

	@Override
	public void enjoy() {
		System.out.println(message);
	}
	
	public static FortuneCookie generate() {
		int randomNo = random.nextInt(20);
		
		return new FortuneCookie(fortunes.get(randomNo));
	}
}
