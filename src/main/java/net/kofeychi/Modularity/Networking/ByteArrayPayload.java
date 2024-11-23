package net.kofeychi.Modularity.Networking;
/*
 * ModularityAPI
 * Copyright (c) 2024. Kofeychi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ByteArrayPayload {
    public Object[] Output;
    public ArrayList<byte[]> Payload;
    public ArrayList<byte[]> Sequence;
    public ByteArrayPayload(Object... Input){
        ArrayList<Class> seq=new ArrayList<>();
        ArrayList<Object> pay=new ArrayList<>();
        int i = 0;
        for(Iterator var2 = Arrays.stream(Input).iterator(); var2.hasNext(); ++i) {
            Object obj = var2.next();
            seq.add(obj.getClass());
            pay.add(obj);
            Payload.add(SerializationUtils.serialize(pay));
            Sequence.add(SerializationUtils.serialize(seq));
        }
    }
}
