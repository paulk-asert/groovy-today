@Grab('org.apache.commons:commons-lang3:3.14.0')
import org.apache.commons.lang3.StringUtils

assert StringUtils.capitalize('foo') == 'foo'.capitalize()
