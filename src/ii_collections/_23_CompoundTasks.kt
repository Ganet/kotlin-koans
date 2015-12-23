package ii_collections

import ii_collections.data.orderedProducts

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> = this.customers.filter { it.orderedProducts.contains(product)}.toSet()


fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return this.orders.filter { it.isDelivered }.flatMap { it.products }.maxBy{ it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.orders }.flatMap { it.products }.count{it == product}
}
