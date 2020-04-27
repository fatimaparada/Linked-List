public class Namelist {
	private Node head;

	// constructor
	public Namelist() {
		head = null;
	}

	// add the name to the list
	public void add(String str) {

		Node newNode = new Node(str, null, false);
		if (str.length() < 2) {
			System.out.println("Name has to be at least two characters long");
			return;
		}
		// if first letter for name already there, just add
		if (letterFound(str.substring(0, 1))) {
			addNode(newNode);
		}
		// else add the letter, then add the name
		else {
			Node newLetterNode = new Node(str.substring(0, 1), null, true);
			addNode(newLetterNode);

			addNode(newNode);
		}
	}

	// remove name and if name is last for a letter, letter removed
	public void remove(String str) {
		// validate
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		// if list is not empty, if the string is just a letter, send to remove letter
		else if (str.length() == 1) {
			removeLetter(str);
			return;
		}

		// removing name
		Node previous = head;
		Node current = head.nod;

		while (current != null) {

			// if string is already not there, connect node to previous
			if (str.compareTo(current.getstr()) == 0) {
				previous.nod = current.nod;
				break;
			} else {
				previous = current;
				current = current.nod;
			}
		}

		// remove letters left
		previous = head;
		current = head.nod;

		// node before previous
		Node temp = null;

		while (current != null) {
			if (previous.checkLetter() && current.checkLetter()) {
				if (temp == null) {
					head = current;
					return;
				}

				else {
					temp.nod = current;
					return;
				}
			} else if (current.checkLetter() && current.nod == null) {
				previous.nod = null;
				return;
			} else {
				temp = previous;
				previous = current;
				current = current.nod;
			}

		}
	}

	// removes letters and all names for that letter
	public void removeLetter(String letter) {
		// get first letter
		char ch = (letter.toCharArray())[0];

		// find
		if (letter.compareTo(head.getstr()) == 0) {
			Node newhead = head.nod;

			// find all names with letter
			while (newhead != null) {
				if (ch == newhead.getstr().charAt(0)) {
					newhead = newhead.nod;
				} else {
					head = newhead;
					return;
				}
			}
		}
		Node previous = head;
		Node current = head.nod;

		// replace them
		while (current != null) {
			if (ch == current.getstr().charAt(0)) {
				previous.nod = current.nod;
				current = current.nod;
			} else {
				previous = current;
				current = current.nod;
			}
		}
	}

	// finds a name by traversing nodes
	public void find(String str) {
		Node current = head;

		while (current != null) {

			// strings match
			if (str.compareTo(current.getstr()) == 0) {
				System.out.println("Found");
				break;
			} else {
				current = current.nod;
				System.out.println("Not Found");
			}

		}
	}

	// returns string of the list formatted as shown in text
	public String toString() {

		Node current = head;
		while (current != null) {
			if (current.checkLetter())
				System.out.println(current.getstr());
			else
				System.out.println(" " + current.getstr());

			current = current.nod;
		}
		return null;
	}

	// display all methods of namelist class
	public void main() {
		add("Fatima");
		add("Fer");
		add("Alejandro");
		add("Alex");
		add("Mariana");
		add("Sherin");
		remove("Sherin");
		remove("Alex");
		removeLetter("F");
		find("Mariana");
		find("Tom");
		toString();
	}

	// NODE CLASS
	class Node {
		private String str;
		private Node nod;
		private boolean checkLetter;

		//constructor
		Node(String str, Node nod, boolean checkLetter) {
			this.str = str;
			this.nod = nod;
			this.checkLetter = checkLetter;
		}

		//returns name or letter
		public String getstr() {
			return str;
		}

		public void setstr(String str) {
			this.str = str;
		}

		//return current node
		public Node getNode() {
			return nod;
		}

		public void setNode(Node nod) {
			this.nod = nod;
		}

		//if letter
		public boolean checkLetter() {
			return checkLetter;
		}

		public void setLetterNode(boolean checkLetter) {
			this.checkLetter = checkLetter;
		}
	}

	//adds node in list
	private void addNode(Node node) {
		
		//list empty
		if (head == null) {
			head = node;
			return;
		}
		
		//put node before the current node
		if (node.getstr().compareTo(head.getstr()) < 0) {
			node.nod = head;
			head = node;
			return;
		}
		Node current = head.nod;
		Node previous = head;
		//shifts
		while (current != null) {
			if (node.getstr().compareTo(current.getstr()) < 0) {
				node.nod = current;
				previous.nod = node;
				return;
			} else {
				previous = current;
				current = current.nod;
			}
		}
		//last node
		previous.nod = node;

	}

	private boolean letterFound(String str) {
		
		boolean isLetter = false;
		Node current = head;
		
		//goes through to find letter
		while (current != null) {
			if (current.checkLetter() && str.compareTo(current.getstr()) == 0) {
				isLetter = true;
				break;
			} else {
				current = current.nod;
			}
		}
		return isLetter;
	}

}