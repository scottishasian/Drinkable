package com.example.kynansong.drinkable.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kynansong on 05/12/2017.
 */

public class CocktailsSeeds {

    CocktailsRepo cocktailsRepo;
    Context context;

    public CocktailsSeeds(Context context) {
        this.cocktailsRepo = new CocktailsRepo(context);
        this.context = context;

    }

    public void CocktailSeeds(SQLiteDatabase db) {
        cocktailsRepo.insertCocktails(db, "Mojito", "50ml Rum, 8 Mint leaves, 15ml Gomme, 25ml Lime"
                , "Muddle the lime, sugar and mint, then stir in the rum over crushed ice. Finish with Soda.");

        cocktailsRepo.insertCocktails(db, "Old Fashioned", "50ml Bourbon or Rum, 1 sugar cube, 3 dashes Orange bitters, 3 dashes Angostura bitters"
                , "Muddle the sugar and bitters into a treacle, then stir in the bourbon over ice.");

        cocktailsRepo.insertCocktails(db, "Paloma", "50ml Tequila, 12.5ml Lime Juice, 75ml Grapefruit Juice/Soda, 12.5ml Agave, salt rim"
                , "Build and stir in glass over ice.");

        cocktailsRepo.insertCocktails(db, "Whisky Mac", "50ml Whisky, 25ml Ginger Wine"
                , "Build and stir in glass over ice.");

        cocktailsRepo.insertCocktails(db, "Daiquiri", "50ml Rum, 12.5ml Cointreau, 12.5ml Lime"
                , "Add to shaker then double strain into glass."); //5

        cocktailsRepo.insertCocktails(db, "Espresso Martini", "25ml Vodka, 25ml Kahlua, 50ml Coffee"
                , "Add to shaker, shake well, then double strain into glass.");

        cocktailsRepo.insertCocktails(db, "White Russian", "25ml Vodka, 25ml Kahlua, 50ml Milk"
                , "Build and stir over ice.");

        cocktailsRepo.insertCocktails(db, "Martini", "50ml Vodka or Gin, 5-10ml Dry Vermouth",
                "Stir ingredients over ice, strain into martini glass");

        cocktailsRepo.insertCocktails(db, "Southside", "50ml Gin, 25ml Lime, 12.5ml Sugar, 1 Mint Leaf garnish",
                "Shake and double strain into a martini or coupe.");

        cocktailsRepo.insertCocktails(db, "Manhattan", "50ml Bourbon, 20ml Vermouth, 2 dashes Angostura Bitters)",
                "Stir ingredients over ice, strain into martini glass. 20ml Sweet Vermouth (Sweet Manhattan)" +
                        ", 20ml Dry Vermouth (Dry Manhattan) or 10ml Sweet, 10ml Dry (Perfect Manhattan)"); //10

        cocktailsRepo.insertCocktails(db, "Margarita", "37.5ml Tequila, 25ml Lime, 12.5ml Cointreau, 10ml Sugar, Salt rim",
                "Shake and double strain into a martini or coupe.");

        cocktailsRepo.insertCocktails(db, "Tommy's Margarita", "50ml Tequila, 25ml Lime, 10ml Agave, Salt rim",
                "Shake and double strain into a martini or coupe.");

        cocktailsRepo.insertCocktails(db, "Caipirinha", "50ml Cachaca, 6 Lime wedges, 10ml Sugar",
                "Muddle the lime and sugar together then stir in the Cachaca over crushed ice. ");

        cocktailsRepo.insertCocktails(db, "Caprioska", "50ml Vodka, 6 Lime wedges, 10ml Sugar",
                "Muddle the lime and sugar together then stir in the Vodka over crushed ice. ");  //14

        cocktailsRepo.insertCocktails(db, "Mescal Negroni", "25ml Mescal, 25ml Sweet Vermouth, 25ml Campari",
                "Add to mixing glass with ice, stir to dilute and then strain into glass.");

        cocktailsRepo.insertCocktails(db, "Negroni", "25ml Gin, 25ml Sweet Vermouth, 25ml Campari",
                "Add to mixing glass with ice, stir to dilute and then strain into glass.");

        cocktailsRepo.insertCocktails(db, "The Last Word", "25ml Green Charteuse, 25ml Gin, 25ml Maraschino Liqueur, 25ml Lime",
                "Add ingredients to a shaker then double strain into glass."); //17

        cocktailsRepo.insertCocktails(db, "Bramble", "50ml Gin, 25ml Lemon Juice, 15ml Sugar, 15ml Chambord",
                "Add ingredients to a shaker then strain into glass over crushed ice, drizzle Chambord on top."); //18

        cocktailsRepo.insertCocktails(db, "Buckfast Daiquiri", "25ml Rum, 25ml Buckfast, 25ml Lime Juice, 15ml Sugar",
                "Add ingredients to a shaker then double strain into a glass."); //19

        cocktailsRepo.insertCocktails(db, "Bloody Mary", "50ml Vodka, 25ml Lemon Juice, 50ml Tomato Juice, 10ml Olive Brine, 10ml Port, Salt, Pepper",
                "Build in glass, add in cucumber, basil and spices if desired."); //20

        cocktailsRepo.insertCocktails(db, "Hemingway Daiquiri", "50ml Rum, 10ml Maraschino Liqueur, 12.5ml Lime, 35ml Grapefruit Juice, 10ml Sugar"
                , "Add to shaker then double strain into glass.");//21

    }

}
