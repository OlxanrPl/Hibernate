package hibernate.dto;

public class SumProductDTO {
  public String peProduct;
  public Double peSuma;

  public SumProductDTO(String peProduct, Double peSuma) {
    this.peProduct = peProduct;
    this.peSuma = peSuma;
  }

  @Override
  public String toString() {
    return "SumProductDTO{" +
        "peProduct='" + peProduct + '\'' +
        ", peSuma=" + peSuma +
        '}'+'\n';
  }
}
