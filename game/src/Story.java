/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class Story {
	private Functions f = new Functions();
	
	/**
	 * Prints text voor het verhaal
	 */
	public void IntroText() {
		f.printText("special agent");
		f.printText("Neil Indiana Musk");
		f.Pause(3);
		f.printText("Profession");
		f.printText("Astronaut, professor of Archeology and founder of SpaceX");
		f.Pause(3);
		
		f.printText("Speciality");
		f.printText("Solving mysteries and destroying CyberTrucks");
		f.Pause(3);
		
		f.printText("Location: Alpha Centauri System 4.39 light years away from planet Earth");
		f.printText("Time: 23 January, 2523");
		f.Pause(3);
		
		f.printText("You are on a mission to deliver a plumbus to Lrrr, ruler of the Planet Omicron Persei 8.");
		f.printText("You are having a great time with your fellow crew members,");
		f.printText("when suddenly after taking a sip of Space-Vodka crew member Carise v.");
		f.printText("Houten falls on the floor. After about 15 seconds she stands up, her skin is severely damaged,");
		f.printText("and her eyes seem to have turned red/yellow.");
		f.printText("What happened?", 300);
		f.printText("She starts walking towards your crew members and bites someone in the face,");
		f.printText("now you and all your members started running.");
		f.printText("The Space-Vodka must’ve been poisoned with some kind of virus.");
		f.printText("You suddenly realize that you are tonight’s bob.");
		f.printText("Everyone else will become infected!");
		f.printText("Your survival instinct tells you YOU HAVE TO GET OUT.");
		f.printText("So you run to the nearest room that can be locked off.");
		f.printText("You’re safe, for now…");
		f.printText("but you are stuck.");
		f.printText("Your oxygen is almost empty and have little food left");
		f.Pause(3);
		
		f.printText("Objective");
		f.printText("You have to get to the escape pod.");
		f.printText("Find the keys and kill the enemy’s to find the escape pod.");
		f.printText("You don’t have a lot of time so hurry up.");
		
		f.Pause(3);
		
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room1() {
		f.printText(
				"The ship is on complete lockdown, only a few rooms are available. You are currently inside of the cockpit. ");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room2() {
		f.printText("This is the hallway, Watch out!");
		f.printText("One of your fellow crew members has turned into a space zombie.");
		f.printText("Try to flee, or you will take damage!");
		f.printText("On your left is a storage room. On your right there is another hallway.");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room3() {
		f.printText("You entered a storage room. Try to move on top of the chest and see what happens");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room4() {
		f.printText("Another space zombie! In this hallway you can go left or right. ");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room5() {
		f.printText("Carise v. Houten has turned too! ");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room6() {
		f.printText("You’re are getting very close!");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room7() {
		f.printText("The key should be around here, somewhere... ");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void room8() {
		f.printText("There it is! the escape pod is behind that door!");
	}
	
	/**
	 * Prints text voor het verhaal
	 */
	public void exit() {
		f.printText("Congratulations!");
		f.printText("You’ve found your way to the exit pod!");
		f.printText("You used the escape pod to return to planet Earth and warn Donald Trump.");
		f.printText("He sends one of his missiles to destroy the spaceship and the virus within!");
		f.printText("You become an intergalactic hero and live happily ever after.");
		f.printText("GG");
	}
}
