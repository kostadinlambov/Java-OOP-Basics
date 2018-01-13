package Demo.LiveDemo;

import Demo.LiveDemo.dark.Porter;
import Demo.LiveDemo.dark.Stout;
import Demo.LiveDemo.light.BlondeAle;
import Demo.LiveDemo.light.PaleLager;
import Demo.LiveDemo.red.BrownAle;
import Demo.LiveDemo.red.PaleAle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Beer> listOfBeers = new ArrayList<>();

        String beerInput = reader.readLine();

        while(!beerInput.equalsIgnoreCase("End")){

            Beer orderedBeer = beerCreater(beerInput);

            listOfBeers.add(orderedBeer);
            beerInput = reader.readLine();
        }

        for (Beer beer : listOfBeers) {
            System.out.println(beer);
            if(beer instanceof BrownAle){
                ((BrownAle) beer).throwBeer();
            }
        }
    }

    private static Beer beerCreater(String beerInfo){
        String[] beerTokens = beerInfo.split(" ");
        String beerType = beerTokens[0];
        Double alchPercentage = Double.parseDouble(beerTokens[1]);

        switch(beerType){
            case"PaleLager" : return new PaleLager((alchPercentage));
            case"BlondeAle" : return new BlondeAle((alchPercentage));
            case"PaleAle" : return new PaleAle((alchPercentage));
            case"BrownAle" : return new BrownAle((alchPercentage));
            case"Porter" : return new Porter((alchPercentage));
            case"Stout" : return new Stout((alchPercentage));
        }

        return  null;
    }
}
