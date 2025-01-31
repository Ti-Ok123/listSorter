import utils.ComparableContent;
import utils.List;

public class QuickSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public QuickSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void quickSort() {
        if(!list.isEmpty()) quicksort_intern( 0, laengeList(list));
    }

    private void quicksort_intern(int left, int right) {
    }

    public int laengeList(List<ContentType> list){
        if(list.isEmpty() || list == null) return 0;
        int laenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            laenge++;
            list.next();
        } return laenge;
    }
}
