package subway.view.output;

public class OutputView {

    public void printView(View view) {
        print(view.getText());
    }

    private void print(String string) {
        System.out.println(string);
    }
}
