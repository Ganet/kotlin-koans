package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toCharList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() = this.orders.flatMap { it.products }.toSet()

val Shop.allOrderedProducts: Set<Product> get() = customers.flatMap { it.orderedProducts }.toSet()
