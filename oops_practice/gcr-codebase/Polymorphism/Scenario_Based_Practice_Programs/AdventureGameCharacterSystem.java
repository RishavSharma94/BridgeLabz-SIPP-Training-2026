public class AdventureGameCharacterSystem {

    public static void main(String[] args) {

        GameCharacter[] characters = {
                new Warrior("Thor"),
                new Mage("Merlin"),
                new Archer("Robin"),
                new Warrior("Leon")
        };

        startBattle(characters);
    }

    public static void startBattle(GameCharacter[] characters) {

        int warriors = 0;
        int mages = 0;
        int archers = 0;

        for (GameCharacter character : characters) {

            character.performAttack();

            if (character instanceof Warrior) {
                warriors++;
            } else if (character instanceof Mage) {
                mages++;
            } else if (character instanceof Archer) {
                archers++;
            }
        }

        System.out.println("\nWarriors: " + warriors);
        System.out.println("Mages: " + mages);
        System.out.println("Archers: " + archers);
    }
}

class GameCharacter {

    String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println("Attack");
    }
}

class Warrior extends GameCharacter {

    public Warrior(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with Sword");
    }
}

class Mage extends GameCharacter {

    public Mage(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " casts Magic Spell");
    }
}

class Archer extends GameCharacter {

    public Archer(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " shoots Arrow");
    }
}