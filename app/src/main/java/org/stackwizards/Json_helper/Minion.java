package org.stackwizards.Json_helper;

import java.util.ArrayList;

public class Minion {
      public String Id;
      public String SpriteSheetUrl ; //": "C:\\Users\\00nul\\OneDrive\\Desktop\baseGridFull.png",
      public String SpriteSheetFilename ; //": "baseGridFull.png",
      public String Name; //": "Small Pocket",
      public int Attack ; //": 2,
      public int Defense; //": 1,
      public String Tribe; //": "Pirate",
      public String Class; //": "Pirate",
      public int X ; //": 600,
      public int Y ; //": 1200,
      public int Width; //": 300,
      public int Height; //": 300,
      public int Cost; //": 2,
      public String Description; //": "n character"
      public String RangeType; //": "n character"

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
