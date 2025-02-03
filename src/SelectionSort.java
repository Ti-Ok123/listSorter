import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        int lenge = lengeListe();
        ContentType kleinstes;
        int indexKleinstes = 0;
        list.toFirst();
        for(int j = 0; j < lenge; j++) {

            kleinstes = list.getContent();
            indexKleinstes = j;
            for (int i = j; i < lenge; i++) {
                list.next();
                if(list.getContent().isLess(kleinstes)){
                    kleinstes = list.getContent();
                    indexKleinstes =

                }
            }

        }
    }

    public int lengeListe(){
        int lenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            lenge++;
            list.next();
        }
        list.toFirst();
        return lenge;

    }
}