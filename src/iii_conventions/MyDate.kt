package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearComp = year.compareTo(other.year)
        if(yearComp != 0) return yearComp
        val monthComp = month.compareTo(other.month)
        if(monthComp != 0) return monthComp
        return dayOfMonth.compareTo(other.dayOfMonth)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return this.addTimeIntervals(interval, 1)
}

operator fun MyDate.plus(interval: TimeIntervalWithQuantity): MyDate {
    return this.addTimeIntervals(interval.interval, interval.quantity)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(quantity : Int) : TimeIntervalWithQuantity{
        return TimeIntervalWithQuantity(this, quantity)
    }
}

class TimeIntervalWithQuantity(val interval : TimeInterval, val quantity: Int)



class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
       return object : Iterator<MyDate> {
           var first : MyDate = start

           override fun hasNext(): Boolean {
               if(first <= endInclusive)
                   return true
               else
                   return false
           }

           override fun next(): MyDate {
               val returnValue = first
               first = first.nextDay()
               return returnValue
           }
       }
    }

    operator fun contains(date : MyDate) : Boolean {
        return date <= endInclusive && date >= start
    }
}
