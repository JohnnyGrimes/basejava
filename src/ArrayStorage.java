import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];


    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
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
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size());
        return result;
    }

    int size() {
        int result = 0;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
