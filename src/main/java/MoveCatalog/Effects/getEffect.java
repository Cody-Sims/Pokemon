package MoveCatalog.Effects;

// Returns the type of effect based on the description of the move
public class getEffect {
    public static PlayerEffect getPlayerEffect(String moveDescription){
        // Sharply Raises
        if(moveDescription.equals("Sharply raises user's Attack.")){return new SharplyRaisesAttack();}
        if(moveDescription.equals("Sharply raises user's Defense.")){return new SharplyRaisesDefense();}
        if(moveDescription.equals("Sharply raises user's Special Attack.")){return new SharplyRaisesSpecialAttack();}
        if(moveDescription.equals("Sharply raises user's Special Defense.")){return new SharplyRaisesSpecialDefense();}
        if(moveDescription.equals("Sharply raises user's Speed.")){return new SharplyRaisesSpeed();}
        if(moveDescription.equals("Sharply raises user's Evasiveness.")){return new SharplyRaisesEvasiveness();}

        // Raises
        if(moveDescription.equals("Raises user's Attack.")){return new RaisesAttack();}
        if(moveDescription.equals("Raises user's Defense.")){return new RaisesDefense();}
        if(moveDescription.equals("Raises user's Special Attack.")){return new RaisesSpecialAttack();}
        if(moveDescription.equals("Raises user's Special Defense.")){return new RaisesSpecialDefense();}
        if(moveDescription.equals("Raises user's Speed.")){return new RaisesSpeed();}
        if(moveDescription.equals("Raises user's Evasiveness.")){return new RaisesEvasiveness();}

        return null;
    }

    public static EnemyEffect getEnemyEffect(String moveDescription){
        // Sharply Lowers
        if(moveDescription.equals("Sharply lowers opponent's Attack.")){return new SharplyLowersAttack();}
        if(moveDescription.equals("Sharply lowers opponent's Defense.")){return new SharplyLowersDefense();}
        if(moveDescription.equals("Sharply lowers opponent's Special Attack.")){return new SharplyLowersSpecialAttack();}
        if(moveDescription.equals("Sharply lowers opponent's Special Defense.")){return new SharplyLowersSpecialDefense();}
        if(moveDescription.equals("Sharply lowers opponent's Speed.")){return new SharplyLowersSpeed();}
        if(moveDescription.equals("Sharply lowers opponent's Evasiveness.")){return new SharplyLowersEvasiveness();}

        // Lowers
        if(moveDescription.equals("Lowers opponent's Attack.")){return new LowersAttack();}
        if(moveDescription.equals("Lowers opponent's Defense.")){return new LowersDefense();}
        if(moveDescription.equals("Lowers opponent's Special Attack.")){return new LowersSpecialAttack();}
        if(moveDescription.equals("Lowers opponent's Special Defense.")){return new LowersSpecialDefense();}
        if(moveDescription.equals("Lowers opponent's Speed.")){return new LowersSpeed();}
        if(moveDescription.equals("Lowers opponent's Evasiveness.")){return new LowersEvasiveness();}
        return null;
    }
}
