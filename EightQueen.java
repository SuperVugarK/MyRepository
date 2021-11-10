
public class EightQueen {

	int queens=8;
    // Определяем массив для сохранения результата размещения ферзя
    int[] array=new int[queens];
    static int count=0;
    public static void main(String[] args) {
        EightQueen e = new EightQueen();
        e.check(0);
        System.out.printf("Всего решений% d!",count);
    }

    /**
           * Поместите королеву
     * @param n
     */
    private void check(int n){
        if(n==queens){// Когда n равно 8, это означает, что размещено 8 ферзей
            print();
            return;
        }
        // Расставляем ферзей и решаем, конфликтуют ли они
        for (int i = 0; i < queens; i++) {
            // Помещаем текущего ферзя n в i-й столбец строки
            array[n]=i;
            // Определяем, конфликтует ли текущая позиция
            if(judge(n)){// Не конфликтовать
                // Затем ставим n + 1 ферзей
                check(n+1);
            }
        }
    }
    /**
           * Определите, есть ли конфликт
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                    return false;
            }
        }
        return true;
    }
    /**
           * Распечатать результат размещения королевы
     */
    public void print(){
        count ++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
