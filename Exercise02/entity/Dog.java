package Exercise02.entity;

public class Dog extends Pet{
//    Phương thức kế thừa
//    Dog kế thừa Pet
    public Dog(){
    }
//    Constructor có tham số
    public Dog(String petId, String petName, int age) {
        super(petId, petName, age);
    }
//    Ghi đè phương thức
    @Override
    public void speak() {
        System.out.println("Gâu Gâu");
    }
}
