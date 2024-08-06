package practise;

public class HashMap_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Ankit", 89);
		map.put("Raj", 79);
		map.put("Raju", 69);
		map.put("Manish", 29);
		map.put("Vaibhav", 39);
		map.put("Shiva", 49);
		map.put("Kunal", 59);
		System.out.println(map.toString());
		map.put("Nishant", 409);
		map.put("Arun", 509);
		System.out.println(map);
	}
}
