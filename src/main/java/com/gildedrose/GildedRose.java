package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
      this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      switch (item.name) {
        case "Sulfuras, Hand of Ragnaros":    
          break;

        case "Backstage passes to a TAFKAL80ETC concert" :
          ajusteQuality(item,1);
          if (item.sellIn<11){
              ajusteQuality(item,1);
          }
          if (item.sellIn<=5){
              ajusteQuality(item,1);
          }
          item.sellIn--;
          sePerimer(item,item.quality);
          break;
        case "Aged Brie":
          ajusteQuality(item,1);
          item.sellIn--;
          if (item.sellIn<0) {
            ajusteQuality(item, 1);
          }            
          break;
        case "Conjured Mana Cake":
          if (item.sellIn>=0){
            item.quality -= 2;
          }   
          else{
            item.quality -= 4;
          } 
          item.sellIn--;
          break;
        default:
          item.sellIn--;
          if (item.quality>0) {
              item.quality--;
              sePerimer(item,1);               
          }
          break;
      }

    }
  }

  private void sePerimer(Item item,int var){
    if (item.sellIn<0) {item.quality = item.quality - var;}
  }
  private void ajusteQuality(Item item,int var){
    if (item.quality<50){
        item.quality+=var;}  
  }


}