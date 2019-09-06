public class Main {
    public static void main(String[] args) {
//        new TestMe() {
//            @Override
//            public void printThis() {
//                System.out.println("Hello World");
//            }
//        }.printThis();
        ReportBuilder webReportBuilder = new TextReportBuilder() {
            @Override
            public String buildTitle() {
                return String.format("<h1>%s</h1>", super.buildTitle().trim());
            }
            public String buildBody() {
                return String.format("<p>%s</p>", super.buildBody().trim());
            }
            public String buildConclusion() {
                return String.format("<p>%s</p>", super.buildConclusion().trim());
            }
        };

        System.out.println(webReportBuilder.build());

    }
}

interface TestMe {
    void printThis();
    default int returnOne() {
        return 1;
    }
}

abstract class ReportBuilder {
    String build() {
        return buildTitle() + buildBody() + buildConclusion();
    }
    abstract String buildTitle();
    abstract String buildBody();
    abstract String buildConclusion();
}

class TextReportBuilder extends ReportBuilder {
    @Override
    public String buildTitle() {
        return "Report\n";
    }
    @Override
    public String buildBody() {
        return "Report text.\n";
    }
    @Override
    public String buildConclusion() {
        return "The end\n";
    }
}
