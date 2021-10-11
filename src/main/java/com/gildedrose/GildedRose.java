package com.gildedrose;

class GildedRose {
    Item[] items;


    final int MAXQUALITY = 50;


    public GildedRose(Item[] items) {
        this.items = items;
    }
    
  
    public void addQualityPerDay(Item item){

        item.quality = item.quality + 1;

    }  

    public void removeSellInPerDay(Item item){

        item.sellIn = item.sellIn - 1;

    }


    public void updateBrie(Item item){

        if (item.sellIn == 0){

            if(item.quality <= 48){

                item.quality = item.quality + 2;

            } else {

                item.quality = MAXQUALITY;

            } 
        } 
        
        else if (item.quality <= 50){

            if (item.quality <= 49){

                addQualityPerDay(item);

            }

            removeSellInPerDay(item);

        } 
    }

    
    public void updateConcert(Item item){

        if (item.quality < MAXQUALITY){

            addQualityPerDay(item);

        } 

        if (item.sellIn < 10 && item.quality < MAXQUALITY){

            addQualityPerDay(item);
            
            if (item.sellIn < 5 && item.quality < MAXQUALITY){

                addQualityPerDay(item);
            
                if (item.sellIn < 1){

                    item.quality = 0;

                }
            }
        } 

        if (item.sellIn > 0){

            removeSellInPerDay(item);

        } 
    }  

    public void updateRegular(Item item){

        if (item.sellIn == 0 && item.quality >= 2){

            item.quality = item.quality - 2;

        } else if (item.quality >= 1){

            item.quality = item.quality - 1;
            removeSellInPerDay(item);
            
        } 
    }


    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && items[i].quality <= MAXQUALITY){

                if (items[i].name.equals("Aged Brie")){

                    updateBrie(items[i]);

                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){

                    updateConcert(items[i]);

                } else {

                    updateRegular(items[i]);
                    
                }               
            } 
        }
    }
}