/*
 * This Scala Testsuite was auto generated by running 'gradle init --type scala-library'
 * by 'remington' at '1/13/16 11:07 AM' with Gradle 2.4
 *
 * @author remington, @date 1/13/16 11:07 AM
 */

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LibrarySuite extends FunSuite {
  test("someLibraryMethod is always true") {
    def library = new Library()
    assert(library.someLibraryMethod)
  }
}