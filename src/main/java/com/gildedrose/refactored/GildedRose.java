package com.gildedrose.refactored;

class GildedRose {
  public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
      for (Item item : items) {
          if (!item.name.equals(AGED_BRIE)
                  && !item.name.equals(BACKSTAGE_PASSES)) {
              decrementarCalidad(item);

          } else if (item.quality < 50) {
                  item.quality++;
                  aumentarCalidadBackstage(item);
              }


          decrementarSellIn(item);

          if (item.sellIn < 0) {
            modificarCalidadCaducado(item);
          }
      }
  }
      public void modificarCalidadCaducado(Item item){
        if(item.name.equals(BACKSTAGE_PASSES)){
          item.quality=0;
        }else if (!item.name.equals(AGED_BRIE)) {
          decrementarCalidad(item);
        } else {
          if (item.quality < 50) {
            item.quality++;
          }
        }
      }
      public void decrementarCalidad(Item item){
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
          item.quality--;
        }
      }

      public void decrementarSellIn(Item item){
        if (!item.name.equals(SULFURAS)) {
          item.sellIn--;
        }
      }

      public void aumentarCalidadBackstage(Item item){
        if (item.name.equals(BACKSTAGE_PASSES)) {
          if (item.sellIn < 11) {
            item.quality++;
          }


          if (item.sellIn < 6) {
            item.quality++;
          }

        }
      }
}