import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[1000];
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume result = null;
        for (Resume resume : storage) {
            if (resume != null && uuid.equals(resume.uuid)) {
                result = resume;
                break;
            }
        }
        return result;
    }

    void delete(String uuid) {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i].uuid.equals(uuid)) {
                for(int j = i; j < storage.length - 1; j++) {
                    storage[j] = storage[j+1];
                }
                storage[storage.length - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[0];
        for (int i = 1; i < storage.length; i++) {
            if (storage[i] == null) {
                result = Arrays.copyOfRange(storage, 0, i);
                break;
            }
        }
        return result;
    }

    int size() {
        return getAll().length;
    }
}
