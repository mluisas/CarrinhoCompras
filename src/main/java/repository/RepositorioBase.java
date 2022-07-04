package repository;

import java.util.Collection;

public interface RepositorioBase<EntryType extends ModeloBase<IdType>, IdType>{

    Collection<EntryType> getEntries();

    default EntryType getById(IdType id){
        for(EntryType entry : getEntries()){
            if(entry.getId().equals(id)){
                return entry;
            }
        }
        return null;
    }

    void insert(EntryType entry);

    void update(IdType id, EntryType newValue);

    void delete(IdType id);

}
