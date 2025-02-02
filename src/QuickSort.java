import utils.ComparableContent;
import utils.List;

public class QuickSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public QuickSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void quickSort() {
        if(!list.isEmpty()) quicksort_intern( 1, laengeList(list));
    }

    private void quicksort_intern(int left, int right) {
        int l = left;
        int r = right;

        int pivot = (l+r) / 2;
        list.toFirst();
        for(int i = 1; i < pivot; i++) list.next();
        ContentType pivotElement = list.getContent();
        while(l < r){
            list.toFirst();
            for(int i = 1; i < l; i++) list.next();
            ContentType leftElement = list.getContent();
            while(l < pivot && leftElement.isLess(pivotElement)){
                l++;
                list.next();
                leftElement = list.getContent();
            }
            list.toFirst();
            for(int j = 1; j < r; j++) list.next();
            ContentType rightElement = list.getContent();
            while (r > pivot && (rightElement.isGreater(pivotElement) || rightElement.isEqual(pivotElement))){
                r--;
                list.toFirst();
                for(int j = 1; j < r; j++) list.next();
                rightElement = list.getContent();
            }

            if(l < r){
                swap(list, leftElement, rightElement);
                if(pivotElement.isEqual(leftElement)){
                    pivot = r;
                    l++;
                } else if(pivotElement.isEqual(rightElement)){
                    pivot = l;
                    r--;
                } else {
                    l++;
                    r--;
                }
            }
        }

        if(left < r) quicksort_intern(left, pivot - 1);
        if(l < right) quicksort_intern(pivot+1, right);
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

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        if(!list.isEmpty()){
            List<ContentType> listCopie = list;
            list.toFirst();
            int i = 1, j = 1;
            while(list.hasAccess()){
                if(list.getContent().equals(item1)){
                    list.setContent(item2);
                    i--;
                } else if(list.getContent().equals(item2)){
                    list.setContent(item1);
                    j--;
                } list.next();
            } if(i != 0 || j != 0) list = listCopie;
        }
    }
}
