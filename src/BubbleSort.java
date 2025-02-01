import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        int e = length() -2;
        int i = e;
        int x = e;
        int t = e;
        ContentType uno = null;
        ContentType dos = null;

        list.toFirst();
            while (list.hasAccess()) {
                while (x > 0 && t > 0) {
                        list.toFirst();
                        while (i < 4 ) {
                            list.next();
                            i++;
                        }
                        i = x;
                        if (list.hasAccess()) {
                            uno = list.getContent();
                        }
                        list.next();
                        if (list.hasAccess()) {
                            dos = list.getContent();
                        }

                        if (!(uno == null || dos == null)) {
                            if (uno.isGreater(dos)) {
                                swap(list, uno, dos);
                            } else if (uno.isEqual(dos)) {
                                list.toFirst();
                            } else if (uno.isLess(dos)) {
                                list.toFirst();
                                t--;
                            }
                        }
                        i--;
                        x--;
                }
                if(t == 0){
                    list.toLast();
                    list.next();
                }else {
                    x = e;
                    i = e;
                    t = e;
                }


            }

    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        list.toFirst();
        while (list.hasAccess()){
            if(list.getContent().equals(item2)) {
                list.setContent(item1);
            }else if(list.getContent().equals(item1)){
               list.setContent(item2);
            }
            list.next();
        }
        list.toFirst();
    }

    public int length(){
        int y = 1;
        list.toFirst();
        while(list.hasAccess()){
            list.next();
            y++;
        }
        return y;
    }
}


//im notfall als else nach dem if bedingung für die dos reinehmen.
//uno = null;
//dos = null;
    //    list.toFirst();
//i = 0;
//x = 0;
//t++;
