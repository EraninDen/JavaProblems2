package livecoding;

public class ex6 {
/**
 Мы проводим технический аудит компании, которая занимается расчетом налогов по контракту для других компаний.
 В компании множество отделов, которые пишут софт и считают налоги для разных компаний и стран.
 Мы заметили, что у каждого отдела своя реализация расчета налогов, свои интерфейсы/классы/тесты, хотя с т.з. бизнеса методика очень похожа.
 Пообщавшись с бизнесом стало понятно, что почти каждый отдел считает налог как base(income)
 + custom(income), а оставшиеся как base(income) - custom(income),
 где income - сумма налоговой базы компании, base(x) - методика рассчета базового налога, одинаковая для всех отделов,
 а custom(x) - специфичная часть рассчета каждого отдела.
 В целях приведения кодовой базы к общему виду мы взялись реализовать библиотеку, которая должна позволить унифицировать расчеты для всех отделов.
 Требуется спроектировать и реализовать ее
 /
 public class GoogleTaxCalculator {
 public BigDecimal googleCalculation(double income) {
 return calculateBase(income).add(BigDecimal.valueOf(income 0.3 / 13));
 }

 private BigDecimal calculateBase(double income) {
 return BigDecimal.valueOf(income * 0.87);
 }
 }

 public class TaxCalculatorSber {
 public BigDecimal calculateSber(BigDecimal income) {
 var base = income.multiply(BigDecimal.valueOf(0.87));
 var custom = income.multiply(BigDecimal.valueOf(0.1)).add(BigDecimal.valueOf(0.11));
 return base.subtract(custom);
 }
 }*/
}
