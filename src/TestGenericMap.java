/*
 * Copyright 2016 University of Basel, Graphics and Vision Research Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class TestGenericMap
{

    public static void main(String[] args)
    {
        testGenericList();
        testGenericMap();
    }


    public static void testGenericList()
    {

        class PLZOrt implements Comparable
        {
            String ort;
            int PLZ;

            PLZOrt(int plz, String ort)
            {
                PLZ = plz;
                this.ort = ort;
            }

            @Override
            public int compareTo(Object o)
            {
                PLZOrt other = (PLZOrt) o;
                return PLZ - other.PLZ;
            }

            @Override
            public String toString()
            {
                return ort;
            }
        }

        SortedList<PLZOrt> postleitzahlen = new SortedList<>();

        postleitzahlen.insert(new PLZOrt(5000, "Aarau"));
        postleitzahlen.insert(new PLZOrt(4000, "Basel"));
        postleitzahlen.insert(new PLZOrt(3000, "Bern"));
        postleitzahlen.insert(new PLZOrt(7000, "Chur"));
        postleitzahlen.insert(new PLZOrt(1000, "Lausanne"));
        postleitzahlen.insert(new PLZOrt(6000, "Luzern"));
        postleitzahlen.insert(new PLZOrt(2000, "Neuchatel"));
        postleitzahlen.insert(new PLZOrt(9000, "St.Gallen"));
        postleitzahlen.insert(new PLZOrt(8000, "Zürich"));

        final int query1 = 6999;
        final int query2 = 7000;
        System.out.println("Suche Ortsnamen für PLZ(" + query1 + ") → " + postleitzahlen.find(new PLZOrt(query1, "")));
        System.out.println("Suche Ortsnamen für PLZ(" + query2 + ") → " + postleitzahlen.find(new PLZOrt(query2, "")));
    }


    public static void testGenericMap()
    {
        GenericMap<Integer, String> postleitzahlen = new GenericMap<>();

        postleitzahlen.insert(5000, "Aarau");
        postleitzahlen.insert(4000, "Basel");
        postleitzahlen.insert(3000, "Bern");
        postleitzahlen.insert(7000, "Chur");
        postleitzahlen.insert(1000, "Lausanne");
        postleitzahlen.insert(6000, "Luzern");
        postleitzahlen.insert(2000, "Neuchatel");
        postleitzahlen.insert(9000, "St.Gallen");
        postleitzahlen.insert(8000, "Zürich");

        for (int plz = 6999; plz < 7001; plz++) {
            try {
                System.out.println("Suche Ortsnamen für PLZ(" + plz + ") → " + postleitzahlen.find(plz));
            } catch (RuntimeException e) {
                System.out.println("Kein Ortsnamen gespeichert für PLZ(" + plz + ")");
            }
        }
    }
}