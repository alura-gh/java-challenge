public class ResultModel {
    private final String base;
    private final String target;
    private double conversionRate;
    private final double value;
    private final double result;

    public ResultModel(ResultRecord resultRecord, double value) {
        this.base = resultRecord.baseCode();
        this.target = resultRecord.targetCode();
        this.value = value;
        this.result = Double.parseDouble(resultRecord.conversionRate()) * this.value;
    }

    @Override
    public String toString() {
        return "Resultado: " + this.value + " " + this.base + " son equivalentes a " + this.result + " " + this.target;
    }
}
