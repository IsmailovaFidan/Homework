package hw9.service;

import hw9.dao.CollectionFamilyDao;
import hw9.entity.*;

import java.time.LocalDate;
import java.util.*;

public class FamilyService {
    CollectionFamilyDao db = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return db.getAllFamilies();
    }

    public void displayAllFamilies() {
        db.getAllFamilies().forEach(System.out::println);
    }

    public ArrayList<Family> getFamiliesBiggerThan(int amount) {
        ArrayList<Family> familiesBiggerThan = new ArrayList<>();
        db.getAllFamilies().forEach(family ->
        {
            if (family.countFamily() > amount) familiesBiggerThan.add(family);
        });
        System.out.println(familiesBiggerThan);
        return familiesBiggerThan;
    }

    public ArrayList<Family> getFamilyLessThan(int amount) {
        ArrayList<Family> familiesLessThan = new ArrayList<>();
        db.getAllFamilies().forEach(family ->
        {
            if (family.countFamily() < amount) familiesLessThan.add(family);
        });
        System.out.println(familiesLessThan);
        return familiesLessThan;
    }

    public int countFamiliesWithMemberNumber(int amount) {
        return (int) db.getAllFamilies().stream().filter(family ->
                family.countFamily() == amount).count();
    }

    public void createNewFamily(Human human1, Human human2) {
        db.saveFamily(new Family(human1, human2));
    }

    public void deleteFamilyByIndex(int index) {
        db.deleteFamily(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        int random = (int) (Math.random() * 100);

        if (random > 50) {
            Man boy = new Man(boyName, family.getFather().getSurname(), LocalDate.now().getYear(), random);
            family.addChild(boy);
        } else {
            Woman girl = new Woman(girlName, family.getFather().getSurname(), LocalDate.now().getYear(), random);
            family.addChild(girl);
        }
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family family : db.getAllFamilies()) {
            family.getChildren().removeIf(c -> (LocalDate.now().getYear() - c.getDateOfBirth()) > age);
        }
    }

    public int count() {
        return db.getAllFamilies().size();
    }

    public Family getFamilyById(int index){
        return db.getFamilyByIndex(index);
    }

    public ArrayList<Pet> getPets(int index){
        return db.getAllFamilies().get(index).getPets();
    }

    public void addPet(int index, Pet pet){
        db.getAllFamilies().get(index).getPets().add(pet);
    }

}
