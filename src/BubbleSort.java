import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        int lenge = lengeListe();
        ContentType a;
        ContentType b;

        for(int i = 0; i < lenge; i++){
            list.toFirst();
            a = list.getContent();
            //System.out.println("a ist"+ a);
            list.next();
            b = list.getContent();
            //System.out.println("b ist"+ b);
            for(int j = 0; j < lenge ; j++){
                System.out.println("a ist"+ a+ " und i ist"+j);
                System.out.println("b ist"+ b+" und j ist "+ (j+1));
                if(a.isGreater(b)){
                    swap(list, a,j,b, (j+1));
                }
                a = list.getContent();
                list.next();
                b = list.getContent();
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
        return lenge;
    }

    public <ContentType> void swap(List<ContentType> list, ContentType item1,int indexa, ContentType item2, int indexb) {
        list.toFirst();
        for(int i = 0; i < indexa; i++){
            list.next();
        }
        list.setContent(item2);
        list.toFirst();
        for(int i = 0; i < indexb; i++){
            list.next();
        }
        list.setContent(item1);
        list.toFirst();
        for(int i = 0; i< indexa; i++){list.next();}
}}
