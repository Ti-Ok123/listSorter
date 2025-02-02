import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        ContentType m = null;
        ContentType uno = null;
        ContentType dos = null;
        int i = 0;
        list.toFirst();
        while (list.hasAccess()){
            if(list.hasAccess()) {
                uno = list.getContent();
            }
            list.next();
            if(list.hasAccess()) {
                dos = list.getContent();
            }
            if(uno.isGreater(dos)){
                m = dos;
            }

        }
    }
}