import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int size = 0;


    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
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
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size);
        return result;
    }

    int size() {
        return size;
    }
}
