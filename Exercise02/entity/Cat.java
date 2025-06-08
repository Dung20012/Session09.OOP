package Exercise02.entity;

public class Cat extends Pet{
//    Phương thức kế thừa
//    Cat kế thừa Pet
    public Cat(){
    }
//    Constructor có tham số
    public Cat(String petId, String petName, int age) {
        super(petId, petName, age);
    }
//    Ghi đè phương thức
    @Override
    public void speak() {
        System.out.println("Meo Meo");
    }
}
