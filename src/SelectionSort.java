import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        for(int i = 0; i < laengeList(list) - 2; i++){
            // gehe durch die Liste (jede Runde ab einer Stelle weiter) und ermittle das kleinste Element (minimum)
            list.toFirst();
            for(int k = 0; k < i; k++) list.next();
            ContentType minimum = list.getContent();
            while(list.hasAccess()){
                if(list.getContent().isLess(minimum)){
                    minimum = list.getContent();
                } list.next();
            }

            //gehe erneut durch die Liste (jede Runde ab einer Stelle weiter) und tausche das Element der Liste, ab
            //dem man in dem Durchlauf gestartet ist, mit dem kleinsten Element.
            list.toFirst();
            for(int k = 0; k < i; k++) list.next();
            ContentType item1 = list.getContent();
            list.setContent(minimum);
            list.next();
            while(!list.getContent().equals(minimum)) list.next();
            list.setContent(item1);
        }
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