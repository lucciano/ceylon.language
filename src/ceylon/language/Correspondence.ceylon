doc "Abstract supertype of objects which associate values 
     with keys. `Correspondence` does not satisfy `Category`,
     since in some cases&mdash;`List`, for example&mdash;it is 
     convenient to consider the subtype a `Category` of its
     values, and in other cases&mdash;`Map`, for example&mdash;it 
     is convenient to treat the subtype as a `Category` of its
     entries.
     
     The item corresponding to a given key may be obtained 
     from a `Correspondence` using the item operator:
     
         value bg = settings[\"backgroundColor\"] else white;
     
     The `get()` operation and item operator result in an
     optional type, to reflect the possibility that there is
     no item for the given key."
see (Map, List, Category)
by "Gavin"
shared interface Correspondence<in Key, out Item>
        given Key satisfies Object {
    
    doc "Returns the value defined for the given key, or 
         `null` if there is no value defined for the given 
         key."
    see (items)
    shared formal Item? get(Key key);
    
    doc "Determines if there is a value defined for the 
         given key."
    see (definesAny, definesEvery, keys)
    shared default Boolean defines(Key key) => 
            get(key) exists;
    
    doc "The `Category` of all keys for which a value is 
         defined by this `Correspondence`."
    see (defines)
    shared default Category keys => Keys(this);
    
    doc "Determines if this `Correspondence` defines a value
         for every one of the given keys."
    see (defines)
    shared default Boolean definesEvery({Key*} keys) {
        for (key in keys) {
            if (!defines(key)) {
                return false;
            }
        }
        else {
            return true;
        }
    }
    
    doc "Determines if this `Correspondence` defines a value
         for any one of the given keys."
    see (defines)
    shared default Boolean definesAny({Key*} keys) {
        for (key in keys) {
            if (defines(key)) {
                return true;
            }
        }
        else {
            return false;
        }
    }
    
    doc "Returns the items defined for the given keys, in
         the same order as the corresponding keys."
    see (get)
    shared default Item?[] items({Key*} keys) =>
            [ for (key in keys) get(key) ];
    
}
