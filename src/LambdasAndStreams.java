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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdasAndStreams
{

    public static PLZOrt[] getData()
    {
        PLZOrt[] plzo = {
                new PLZOrt(5000, "Aarau"),
                new PLZOrt(4000, "Basel"),
                new PLZOrt(3000, "Bern"),
                new PLZOrt(7000, "Chur"),
                new PLZOrt(1000, "Lausanne"),
                new PLZOrt(6000, "Luzern"),
                new PLZOrt(2000, "Neuchatel"),
                new PLZOrt(9000, "St.Gallen"),
                new PLZOrt(8000, "Zürich")};
        return plzo;
    }

    public static void main(String[] args)
    {

        int threshold = 5000;

        Predicate<PLZOrt> filter = new Predicate<PLZOrt>()
        {

            @Override
            public boolean test(PLZOrt plzOrt)
            {
                return plzOrt.PLZ < threshold;
            }
        };


        Comparator<PLZOrt> comparator = new Comparator<PLZOrt>()
        {
            @Override
            public int compare(PLZOrt a, PLZOrt b)
            {
                return a.PLZ - b.PLZ;
            }
        };


        List<PLZOrt> list = Arrays.asList(getData());

        Stream<PLZOrt> stream = list.stream();

        stream
                .filter(filter)
                .sorted(comparator)
                .map((PLZOrt it) -> new PLZOrt(it.PLZ + 1, it.ort))
                .forEach(justPrintIt());

    }

    public static Consumer<PLZOrt> justPrintIt()
    {
        // Equivalent: return t -> System.out.println(t);

        return new Consumer<PLZOrt>()
        {
            @Override
            public void accept(PLZOrt t)
            {
                System.out.println(t);
            }
        };
    }

    private static class PLZOrt
    {
        public int PLZ;
        public String ort;

        public PLZOrt(int PLZ, String ort)
        {
            this.PLZ = PLZ;
            this.ort = ort;
        }

        @Override
        public String toString()
        {
            return ort + "[" + PLZ + "]";
        }
    }

}
