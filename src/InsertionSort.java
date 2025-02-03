import utils.ComparableContent;
import utils.List;

public class InsertionSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public InsertionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void insertionSort() {
        int laengeListe = laengeList(list);
        for (int i = 0; i < laengeListe; i++) {
            for (int j = 0; j < laengeListe - 1; j++) {
                list.toFirst();
                ContentType current = list.getContent();
                for (int k = 1; k < j; k++) {
                    list.next();
                }
                if (current.isGreater(list.getContent())){
                    list.next();
                }else if (current.isLess(list.getContent())){
                    list.insert(current);
                    while(!list.getContent().equals(current)) list.next();
                    list.remove();
                    break;
                }

            }
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
