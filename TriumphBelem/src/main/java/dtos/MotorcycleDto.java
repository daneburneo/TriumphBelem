package dtos;

public class MotorcycleDto {


  private Integer id;

  private String name;

  private String model;

  private Double price;

  private Integer total;

  private Double discount;

  private Integer engineId;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Integer getEngineId() {
    return engineId;
  }

  public void setEngineId(Integer engineId) {
    this.engineId = engineId;
  }
}



