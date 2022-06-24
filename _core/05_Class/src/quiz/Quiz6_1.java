package quiz;
class Pet{
	int age;
	String name;
	void sound() {
		System.out.println(name + "이(가) 소리를 냅니다");
	}
	int getOlder(){
		age++;
		return age;
	}
	
}
public class Quiz6_1 {

	public static void main(String[] args) {
		Pet my_pet = new Pet();
		call_pet(my_pet);

	

	}

	private static void call_pet(Pet my_pet) {
		System.out.println(my_pet.name);
		int age = my_pet.age;
		System.out.println("증가전 나이 :" + age);
		age = my_pet.getOlder();
		System.out.println("증가 후 나이 : " + age);
		my_pet.sound();
		
	}

}
