package ru.nf.conveyor.utils;

/**
 * Утилитный класс для расчета ежемесячной ставки
 */
public class MonthlyRateUtil {

	/**
	 * ставка по кредиту/(100*12) -> ежемесячная % ставка
	 *
	 * @param rate ставка по кредиту
	 * @return ежемесячная ставка
	 */
	public static Double monthlyRate(Double rate) {
		return rate / (100 * 12);
	}
}
