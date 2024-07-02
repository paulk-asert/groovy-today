//@Grab('org.apache.commons:commons-lang3:3.14.0')
import org.apache.commons.lang3.StringUtils

assert StringUtils.capitalize('groovy') == 'Groovy'

assert 'groovy'.class.name == 'java.lang.String'
assert 'groovy'.capitalize() == 'Groovy'
