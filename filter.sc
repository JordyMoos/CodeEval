
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

class FilterFactory {
  val factories: MutMap[String, Seq[String] => Filter] = MutMap()
  def add(alias: String, factory: Seq[String] => Filter) = {
    factories(alias) = factory
  }

  def create(alias: String, config: Seq[String] = Seq()): Option[Filter] = {
    if ( ! factories.contains(alias)) None
    else Some(factories(alias)(config))
  }
}

val factory = new FilterFactory
factory.add("scope", config => new ScopeFilter(config))
factory.add("type", config => new TypeFilter(config.map(_.toInt)))
factory.add("top_level", config => new TopLevelFilter)

val a = Category(Array[Int](), "category")
val b = Category(Array(1, 2), "game")
val c = Category(Array(3), "article", Some(a))

val filterScope = factory.create("scope", Array("category")).get
filterScope(a)
filterScope(b)
filterScope(c)

val filterType = factory.create("type", Array("1")).get
filterType(a)
filterType(b)
filterType(c)

val filterTop = factory.create("top_level").get
filterTop(a)
filterTop(b)
filterTop(c)


