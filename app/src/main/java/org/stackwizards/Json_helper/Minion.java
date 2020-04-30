package org.stackwizards.Json_helper;

public class Minion {
      public String Id;
      public String SpriteSheetUrl ;
      public String SpriteSheetFilename ;
      public String Name;
      public int Attack ;
      public int Defense;
      public String Tribe;
      public String Class;
      public int X ;
      public int Y ;
      public int Width;
      public int Height;
      public int Cost;
      public String Description;
      public String RangeType;
//      public ArrayList<Ability> Abilities;

      public Minion(){
            Name = "NEXT";
            Tribe = "None";
//            Abilities = new ArrayList<>();
      }

      public Minion(Minion m) {
            Id = m.Id;
            SpriteSheetUrl = m.SpriteSheetUrl;
            SpriteSheetFilename = m.SpriteSheetFilename;
            Name = m.Name;
            Attack = m.Attack;
            Defense = m.Defense;
            Tribe = m.Tribe;
            Class = m.Class;
            X = m.X;
            Y = m.Y;
            Width = m.Width;
            Height = m.Height;
            Cost = m.Cost;
            Description = m.Description;
            RangeType = m.RangeType;
//            this.Abilities = m.Abilities;
      }
}
