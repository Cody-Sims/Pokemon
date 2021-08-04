package MoveCatalog.Effects;

public class getEffect {
    public static Effect getEffect(String moveDescription){
        if(moveDescription.equals("Sharply raises user's Attack.")){return new SharplyRaisesAttack();}
        if(moveDescription.equals("Sharply raises user's Defense.")){return new SharplyRaisesAttack();}
        if(moveDescription.equals("Sharply raises user's Special Attack.")){return new SharplyRaisesAttack();}
        if(moveDescription.equals("Sharply raises user's Special Defense.")){return new SharplyRaisesAttack();}
        if(moveDescription.equals("Sharply raises user's Speed.")){return new SharplyRaisesAttack();}

        return null;
    }
}
