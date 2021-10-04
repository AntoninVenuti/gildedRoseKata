package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateBrie(Item item){

        if (item.sellIn == 0){
            if( item.quality <= 48){
                item.quality = item.quality + 2;
            } else{
                item.quality = 50;
            } 
        } else if (item.quality <=49){

            item.quality = item.quality + 1;
            item.sellIn = item.sellIn - 1;

        } 

    }

    public void updateConcert(Item item){

        if (item.quality < 50){

            item.quality = item.quality + 1;

        } 

        if (item.sellIn < 10 && item.quality < 50){

            item.quality = item.quality + 1;
            
            if (item.sellIn < 5 && item.quality < 50){

                item.quality = item.quality + 1;
            
                if (item.sellIn < 1){

                    item.quality = 0;

                }

            }
        } 

    }  

    public void updateRegular(Item item){

        if (item.sellIn == 0 && item.quality >= 2){

            item.quality = item.quality - 2;

        } else if (item.quality >= 1){

            item.quality = item.quality - 1;
            item.sellIn = item.sellIn - 1;
            
        } 

    }

    public void updateConjured(Item item){

        if (item.sellIn == 0 && item.quality >= 4){

            item.quality = item.quality - 4;

        } else if(item.quality >=2){

            item.quality = item.quality - 2;
            item.sellIn = item.sellIn - 1;
            
        } 

    } 

    


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            //Test
            
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")){
                
                if (items[i].quality <= 50){

                    if (items[i].name.equals("Aged Brie")){
                        updateBrie(items[i]);
                    } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                        updateConcert(items[i]);
                    } else if (items[i].name.contains("Conjured")){
                        updateConjured(items[i]);
                    } else {
                        updateRegular(items[i]);
                    } 
                    
                }
            } 
            /*
            

            

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
           */ 

        }
    }
}