
import scala.collection.mutable.{Map => MutMap}

case class Category(typeIds: Seq[Int], scope: String, parent: Option[Category] = None)

trait Filter {
  def apply(category: Category): Boolean
}

class ScopeFilter (private val scopes: Seq[String]) extends Filter {
  def apply(category: Category): Boolean = {
    scopes.contains(category.scope)
  }
}

class TypeFilter (private val types: Seq[Int]) extends Filter {
  def apply(category: Category): Boolean = {
    category.typeIds.intersect(types).nonEmpty
  }
}

class TopLevelFilter extends Filter {
  def apply(category: Category): Boolean = {
    category.parent.isEmpty
  }
}

trait FilterFactoryInterface {
  def create(config: Seq[String]): Filter
}

object ScopeFilter extends FilterFactoryInterface {
  def create(config: Seq[String]) = {
    new ScopeFilter(config)
  }
}
object TypeFilter extends FilterFactoryInterface {
  def create(config: Seq[String]) = {
    new TypeFilter(config.map(_.toInt))
  }
}
object TopLevelFilter extends FilterFactoryInterface {
  def create(config: Seq[String]) = {
    new TopLevelFilter
  }
}

class FilterFactory {
  val factories: MutMap[String, FilterFactoryInterface] = MutMap()
  def add(alias: String, factory: FilterFactoryInterface) = {
    factories(alias) = factory
  }

  def create(alias: String, config: Seq[String] = Seq()): Option[Filter] = {
    if ( ! factories.contains(alias)) None
    else Some(factories(alias).create(config))
  }
}

val factory = new FilterFactory
factory.add("scope", ScopeFilter)
factory.add("type", TypeFilter)
factory.add("top_level", TopLevelFilter)

val a = Category(Array[Int](), "category")
val b = Category(Array(1, 2), "game")
val c = Category(Array(3), "article", Some(a))

val filterScope = factory.create("scope", Array("category")).get
filterScope(a)
filterScope(b)
filterScope(c)

val filterType = factory.create("scope", Array("1")).get
filterType(a)
filterType(b)
filterType(c)

val filterTop = factory.create("top_level").get
filterTop(a)
filterTop(b)
filterTop(c)


