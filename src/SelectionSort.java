import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        int laengeListe = laengeList(list);
        for(int i = 0; i < laengeListe; i++){
            list.toFirst();
            for(int l = 0; l < i; l++) list.next();
            ContentType smallest = list.getContent();

            for(int j = i; j < laengeListe; j++){
                ContentType current = list.getContent();
                if(smallest.isGreater(current)){
                    smallest = list.getContent();
                }
                list.next();
            }
            ContentType dritter = list.getContent();
            list.remove();
            list.toFirst();
            for(int k = 0; k<i; k++) list.next();

            list.insert(smallest);

        }
    }


    //Herr Witt Zitat: Wir haben ganz Typisch, ganz Klassisch einfach nur Stoff!
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